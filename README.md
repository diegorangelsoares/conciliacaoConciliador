# conciliacaoConciliador

Api responsavel pela conciliacao.

Script: create database conciliacaoconciliador;

INSERT INTO public.t_base (id, aplicativo_cobransaas, endereco_cobransaas, ip_cards, porta_cards, senha_cards,
senha_cobransaas, sid_cards, usuario_cards) VALUES (1, 'USUARIO', 'ENDERECO', null, null, null, 'SENHA', null, null);

INSERT INTO public.t_emissor (id, nome, base_id) VALUES (1, 'NOME EMISSOR', 1);
